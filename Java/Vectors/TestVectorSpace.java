public class TestVectorSpace {
    public static void main(String[] args) {
        Vector3D2Norm v1 = new Vector3D2Norm(1,2,3);
        try {
            v1.normalize();
        }
        catch (ArithmeticException exception){
            System.out.println("Division by zero not allowed");
            exception.printStackTrace();
        }
    }
}