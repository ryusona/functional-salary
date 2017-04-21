import javafx.scene.shape.Path;
import salaries.model.Salary;
import salaries.model.chio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.*;

/**
 * Created by danawacomputer on 2017-04-21.
 */
public class StreamDemo { // 스트림에서 바로 파일 처리하는 예제 (매핑)

    public static void main(String args[]) {

        try {

            // 1. 리스트로 바로 넣는 예제
            List<Salary> list =
            Files.lines(Paths.get("src\\Salaries.csv"))  // 스트링형 스트림이 만들어짐
                    .skip(1) // 첫번째 줄 생략
                    .map(x -> {
                        String [] spl = x.split(","); // 스트링형이기 때문에 바로 스플릿
                        return new Salary( // 샐러리 객체에 바로 생성
                                LocalDate.of(Integer.parseInt(spl[0]),1,1),
                                spl[1],spl[2],spl[3],Integer.parseInt(spl[4]));
                    }) // 따로 안돌리고 함수형 프로그램으로 처리해본 예제
                    .collect(Collectors.toList()); // collect를 이용하여 바로 List로 저장
                    //.forEach(System.out::println); // 프린트

            // 2. 맵으로 넣는 예제
            Map<String, Salary> listMap =
                    Files.lines(Paths.get("src\\Salaries.csv"))  // 스트링형 스트림이 만들어짐
                            .skip(1) // 첫번째 줄 생략
                            .map(x -> {
                                String [] spl = x.split(","); // 스트링형이기 때문에 바로 스플릿
                                return new Salary( // 샐러리 객체에 바로 생성
                                        LocalDate.of(Integer.parseInt(spl[0]),1,1),
                                        spl[1],spl[2],spl[3],Integer.parseInt(spl[4]));
                            }) // 따로 안돌리고 함수형 프로그램으로 처리해본 예제
                            .collect(Collectors.toMap(
                                    s -> String.valueOf(new Random().nextInt()), s -> s));
                                                    // collect를 이용하여 바로 List로 저장
            //.forEach(System.out::println); // 프린트
            listMap.forEach((k, v) -> System.out.println(k + " : " + v));





            // Stream.of("a","b","c").forEach(System.out::println);
            // Stream.of(1,2,3,4,5).forEach(System.out::println);

//            long sum = LongStream.range(1,10000000) // 1부터 100000까지 만들어줌 -> 유한 스트림
//                    .sum(); // 그들의 합
//            System.out.println(sum);
//
//            IntStream.generate(() -> 1).limit(1).forEach(System.out::println); // 무한 스트림 (1을 계속 뽑아냄)
//
//            Random r = new Random();
//           // List<chio> chiolist =
//            r.ints(1,7)
//                    .limit(100000)
//                    .forEach(System.out::println);
//            // ints(시작값,끝값+1)

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

