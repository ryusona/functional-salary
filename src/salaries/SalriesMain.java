package salaries;

import salaries.model.Salary;
import salaries.serivce.SlriesService;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class SalriesMain {
    public static void main(String args[ ]) {

        List<Salary> list = SlriesService.makeListFromCSV("src\\Salaries.csv");

        OptionalDouble dd =
                list.stream()
                        .filter(x -> (x.getYearID().getYear() <= 1999 && x.getYearID().getYear() >= 1985))
                        .mapToInt(x -> x.getSalary())
                        .average();

        if (dd.isPresent()) {
            System.out.printf("1990년대 평균 연봉 : %.1f \n",dd.getAsDouble()); // 값을 double로 가져옴
        } else System.out.println("값이 없어요");

        OptionalDouble allRd =
                list.stream()
                        .mapToInt(x -> x.getSalary())
                        .average();

        if (allRd.isPresent()) {
            System.out.printf("전체 레코드의 평균 : %.1f \n",allRd.getAsDouble()); // 값을 double로 가져옴
        } else System.out.println("값이 없어요");

        OptionalInt maxSalarie =
                list.stream()
                .mapToInt(x -> x.getSalary())
                .max();
        System.out.printf("최고 연봉자 %d  ", maxSalarie.getAsInt());

        OptionalInt minSalarie =
                list.stream()
                .mapToInt(x -> x.getSalary())
                .min();
        System.out.printf("최소 연봉자 %d\n", minSalarie.getAsInt());

        list.stream()
                .filter(x -> (x.getLgID().equals("NL"))) // 1단계
                .sorted((x,y) -> y.getSalary() - x.getSalary())
                .limit(1).peek(x-> System.out.println(x.getPlayerID()));
        // System.out.printf("NL의 최고 연봉자 %d \n", optionalInt.getAsInt());

        OptionalDouble avergOfNYY =
                list.stream()
                .filter(x -> (x.getTeamID().equals("NYY")))
                .mapToInt(x -> x.getSalary())
                .average();
        System.out.printf("NYY구단의 평균 %.1f \n", avergOfNYY.getAsDouble());

        OptionalDouble averageOfTopTen =
                list.stream()
                .sorted((x,y) -> y.getSalary() - x.getSalary())
                .mapToInt(x -> x.getSalary())
                .limit(10)
                .average();

        System.out.printf("최상위 10명의 평균 %.1f \n", averageOfTopTen.getAsDouble());

    }

// 1900년대 평균연봉을 구하세요 (1985~ 1999)
// 전체 레코드의 평균연봉을 구하세요
// 최고연봉자와 최소 연봉자를 구하세요
// NL의 최고 연봉자를 구하세요.
// NYY 구단의 평균연봉을 구하세요.
}


