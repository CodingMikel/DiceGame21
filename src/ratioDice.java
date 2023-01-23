import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ratioDice {
	List<Integer> ratioList;
	private String ratioStore;
	
	public ratioDice(List<Integer> ratioList) {
		this.ratioList = ratioList;
	}
	
	public ratioDice(String ratioExpr) {
		this(Arrays.asList(ratioExpr.split(":")).stream().map(e -> Integer.parseInt(e)).collect(Collectors.toList()));
		this.ratioStore = ratioExpr;	
	}
	
	public int getSelectIndex() {
        Random random = new Random();
        int sum = ratioList.stream().reduce((a, b) -> Integer.sum(a, b)).get().intValue();
        int start = 0;
        int bound = 0;
        int ran = random.nextInt(sum);
        for (int i = 0; i < ratioList.size(); i++) {
            int ratio = ratioList.get(i);
            bound += ratio;
            if (ran >= start && ran < bound) {
                return i;
            }
            start += ratio;
        }
        return -1;
    }
	
	public int rateRoll() {
		ratioDice rris = new ratioDice(ratioStore);
		int index = rris.getSelectIndex();
//		for(int i=0; i<10000; i++) {
//            int testIndex = rris.getSelectIndex();
//            ratioList.add(testIndex);
//        }
//		long r0 = ratioList.stream().filter(i -> i == 0).count();
//        long r1 = ratioList.stream().filter(i -> i == 1).count();
//        long r2 = ratioList.stream().filter(i -> i == 2).count();
//        long r3 = ratioList.stream().filter(i -> i == 3).count();
//        long r4 = ratioList.stream().filter(i -> i == 4).count();
//        long r5 = ratioList.stream().filter(i -> i == 5).count();
//        long r6 = ratioList.stream().filter(i -> i == 6).count();
//        System.out.println("Toal count: "+r0+"  "+r1+"  "+r2+"  "+r3+ " " + r4 + " " + r5 + " " + r6);
        return index;
	}
}
