public class VectorSpace3D2Norm implements VectorSpace{
    
    public Vector3D add(Vector3D v1, Vector3D v2){
        //To find the sum of the two vectors.
        return new Vector3D2Norm(v1.x + v2.x , v1.y + v2.y , v1.z + v2.z);
    }

    
    public double scalarProduct(Vector3D v1, Vector3D v2){
        //To fined the scalar product for the two vectors.
        //by multiply each components of the v1 with the smailer components of the v2 and find the some of them.
        return (v1.x * v2.x + v1.y * v2.y + v1.z * v2.z);
    }

    
    public double distance(Vector3D v1, Vector3D v2){
        //To find the the distance for the two vectors.
        //by subtract each components of the v1 with the smailer components of the v2 and find the some of them.
        return ((v2.x - v1.x) + (v2.y - v1.y) + (v2.z - v1.z));
    }
}