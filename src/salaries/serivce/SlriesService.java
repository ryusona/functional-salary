package salaries.serivce;

import com.opencsv.CSVReader;
import salaries.model.Salary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by danawacomputer on 2017-04-20.
 */
public class SlriesService {

    public static List<Salary> makeListFromCSV(String filename) {

        List<Salary> list = new ArrayList<>(); //container for Park objects. null 쓰지 않으려고. 예외가 발생하면 비어있는 list가 return 됨

        try {
            CSVReader reader = new CSVReader(new FileReader(filename)); //split 사용 안 해도 됨.
            reader.readNext(); //skip the first line
            String[] spl = null;

            //  프로그램할때 가장 중요한건 객체를 생성하는 일
            while ((spl = reader.readNext()) != null) {
                // of는 Factory 메소드임 <- 직접 new를 사용하진 않지만 결국엔 new로 반환을 하기 때문에
                LocalDate a = LocalDate.of(Integer.parseInt(spl[0]),1,1);
                list.add(new Salary(a,spl[1],spl[2],spl[3],Integer.parseInt(spl[4])));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;//정상적으로 끝나지 않을 때를 대비 하지만 null 을 return 하는 것은 별로 옳은 일 아님 의도를 알 수 없음.
    }

    public List afterSortList (List<Salary> list){ // 씨티값으로 소팅 하는 부분

        Collections.sort(list, (o1, o2) -> o1.getSalary() - (o2.getSalary()));
        List<Salary> sortParkList = new ArrayList<>();
        sortParkList.addAll(list);

        return  sortParkList;
    }

    public List afterSortListNL (List<Salary> list){ // 씨티값으로 소팅 하는 부분

        Collections.sort(list, (o1, o2) -> o1.getSalary() - (o2.getSalary()));
        List<Salary> sortParkList = new ArrayList<>();
        sortParkList.addAll(list);

        return  sortParkList;
    }

    public static int pliterYear () {
        return 0;
    }


}
