import java.util.*;

public class ProducerConsumerProblem {
	public static int itemP = 1, full = 0, empty = 3, p = 0;

	public static void main(String[] args) {
		int n;
		System.out.print("\n1.Producer\n2.Consumer\n3.Exit");
		while(true) {
			System.out.println();
			System.out.print("\nEnter your choice : ");
			n = in.nextInt();
			switch(n) {
			case 1:
				if(itemP == 1 && empty != 0) {
					producer();
				} else {
					System.out.print("Buffer is FULL.\nFurther production is not allowed.");
				}
				break;
			case 2:
				if(itemP == 1 && full != 0) {
					consumer();
				} else {
					System.out.print("Buffer is empty.\nFurther consumption is not allowed.");
				}
				break;
			case 3:
				System.out.println(" >> EXIT Successful << ");
				System.exit(0);
				break;
			}
		}
	}

	public static int wait(int s) {
		return --s;
	}

	public static int ready(int s) {
		return ++s;
	}

	public static void producer() {
		itemP = wait(itemP);
		full = ready(full);
		empty = wait(empty);
		p++;
		System.out.print("\nProducer produces the item " + p);
		itemP = ready(itemP);
	}

	public static void consumer() {
		itemP = wait(itemP);
		full = wait(full);
		empty = ready(empty);
		System.out.print("\nConsumer consumes the item " + p);
		p--;
		itemP = ready(itemP);
	}

	public final static Scanner in = new Scanner(System.in);
}