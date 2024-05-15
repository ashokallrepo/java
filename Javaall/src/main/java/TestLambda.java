public class TestLambda implements AbcInt11 {
    @Override
    public int myFun(int a, int b) {
        return a + b;
    }

        public static void main(String[] args) {
            TestLambda obj = new TestLambda();
            System.out.println(obj.myFun(10,20));
        }
}

interface AbcInt11
{
    public int myFun(int a, int b);
}
