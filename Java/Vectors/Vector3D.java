public abstract class Vector3D {
    //Defined the x, y, z components of the vector. 
    public double x;
    public double y;
    public double z;

    //Create the three components
    public Vector3D(double x, double y, double z){

        this.x = x;
        this.y = y;
        this.z = z;
    }
    //Multiply three components with the scalar
    public void multiply(double scalar){

        x = x * scalar;
        y = y * scalar;
        z = z * scalar;
    }
    public void normalize() throws ArithmeticException{
        //The Exception will be thrown if the magnitueds of the vector equal zero.
        if (magnitude() == 0.0){ 

            throw new ArithmeticException();

        }else{
            //Divide the three components by the magnitude of the vector.
            x = x / magnitude();
            y = y / magnitude();
            z = z / magnitude();
        }
    }
    //Return the three components in array.
    public double[] getVector(){

        return new double[]{x ,y, z};

    }
    
    public boolean isZero(){
        //Return ture if the vector is zero.
        if(magnitude() == 0){
            return true;
        }else{
            //Return false if else.
            return false;
        }   
    }
    public String toString(){
        //To return the vector in nicely formatted.
        return "The vector has x : "+x+", and y : "+y+" and z : "+z;
    }

    public abstract double magnitude();
}