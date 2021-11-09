package personal.others;

public class ExcelColumnNumber {

    public int titleToNumber(String A) {
        int sum = 0;
        int j=0;
        for(int i=A.length()-1;i>=0;i--) {
            int multiplier = (int) Math.pow(26,j++);
            int ch = A.charAt(i) -64;
            sum += multiplier*ch;
        }
        return sum;
    }

    public String convertToTitle(int A) {
        StringBuilder sbr = new StringBuilder();
        int i = 6;
        while (A>0) {
            int x = (int) Math.pow(26, i);
            if(x<=A) {

            }
        }
        return "";

    }

    public static void main(String[] args) {
        ExcelColumnNumber excelColumnNumber = new ExcelColumnNumber();
        System.out.println(excelColumnNumber.titleToNumber("BAA"));

        System.out.println(excelColumnNumber.convertToTitle(1000000000));
    }
}
