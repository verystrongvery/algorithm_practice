import java.util.Arrays;

class FileName implements Comparable<FileName>{
    String fileName;
    String head;
    String number;
    String tail;

    public FileName() {

    }

    public FileName(String file) {
        int i = 0;
        int j = 0;
        for(i = 0; i < file.length(); i++) {
            if (!Character.isDigit(file.charAt(i))) {
                continue;
            }
            j = i;
            while(j < file.length() && Character.isDigit(file.charAt(j))) {
                j++;
            }
            break ;
        }
        fileName = file;
        head = file.substring(0, i);
        number = file.substring(i, j);
        tail = file.substring(j, file.length());
    }

    @Override
    public int compareTo(FileName fn) {
        if (!this.head.toLowerCase().equals(fn.head.toLowerCase())) {
            return this.head.toLowerCase().compareTo(fn.head.toLowerCase());
        }
        return Integer.compare(Integer.parseInt(this.number), Integer.parseInt(fn.number));
    }
}
class Solution {
    public String[] solution(String[] files) {
        return Arrays.stream(files)
                .map(FileName::new)
                .sorted()
                .map(fn -> fn.fileName)
                .toArray(String[]::new);
    }
}
