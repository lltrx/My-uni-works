public interface VectorSpace {
    //v1 as vector1 and v2 as vector2.
    Vector3D add(Vector3D v1,Vector3D v2);
    double scalarProduct(Vector3D v1,Vector3D v2);
    double distance(Vector3D v1,Vector3D v2);
}