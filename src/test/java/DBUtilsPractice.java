import utilities.DBUtils;

import java.util.List;

public class DBUtilsPractice {
    public static void main(String[] args) {

        DBUtils.createConnection();

        String maxCreditMusteri = (String) DBUtils.getCellValue("select customerName from customers order by creditLimit desc limit 1;");
        System.out.println("maxCredit limitine sahip musterinin adi: " + maxCreditMusteri);

        List<List<Object>> sonucListesi = DBUtils.getQueryResultList("select customerNumber,customerName,creditLimit from customers;");
        System.out.println("sonucListesi = " + sonucListesi);


    }
}
