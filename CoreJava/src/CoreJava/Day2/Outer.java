package CoreJava.Day2;

public class Outer {

	private int x;
	
	public Inner createInner() {
		return new Inner();
	}
	
	public static interface abcd {
		
		
	}
	
	public abstract static class StaticInner implements abcd{
		public void jumpBy10(Outer o) {
			o.x = o.x+10;
		}
		
		public abstract void jumpBy100(Outer o);
	}
	
	public class Inner{
		
		public void printX() {
			System.out.println("X = "+x);
			
		}
		
		public void increment() {
			x++;
		}
		
	}
	
	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.Inner i = o.createInner();
		Outer.Inner i1 = o.createInner();
		System.out.println(i);
		System.out.println(i1);
		i1.increment();
		i.printX();
		new Outer().createInner().printX(); //new instane does not belong to o instance of outerr object, as it is new object
	
		StaticInner si = new StaticInner() {
			//Anonymous inner class
			@Override
			public void jumpBy100(Outer o) {
				o.x=o.x+100;
			}
		};
		si.jumpBy100(o);
		si.jumpBy10(o);
		i.printX();
		
		Arithmetic a=new Arithmetic() {
			
			@Override
			public int sub(int a, int b) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int mul(int a, int b) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int div(int a, int b) throws DivideByZeroException {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int add(int a, int b) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
	}
	
}
