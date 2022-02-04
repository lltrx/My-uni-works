public class Vector3D2Norm extends Vector3D{

    public Vector3D2Norm(double x, double y, double z){
        super(x, y, z);
    }
    
    public double magnitude(){
       //Using the Euclidean norm to square root each of the three components and sum them together
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }
}