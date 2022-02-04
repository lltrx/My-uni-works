public class Vector2D2Norm extends Vector3D2Norm{
    //The vector2D2Norm is two-dimensional vector but presenting as three-dimensional vector. 
    //Therefore, to be two-dimensional we have to represent z-component as Zero.
    public Vector2D2Norm(double x, double y, double z){
        super(x, y, 0);
    }
}