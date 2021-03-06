public class Qubit {
  final private double tol = .001; // Tolerance of the definition of 1
  int size;
  private Complex[] vec; // Vectorspace of the system. Typically |0>, |1>
  
  public Qubit() {
    size = 2;
    vec = new Complex[2];
    vec[0] = new Complex(1, 0);
    vec[1] = new Complex();
  }
  
  public Qubit(int a) {
    size = a;
    vec = new Complex[a];
    for (int i = 0; i < a; i++) {
      vec[i] = new Complex();
    }
  }
  
  public Qubit(Complex[] init) {
    size = init.length;
    vec = new Complex[init.length];
    for (int i = 0; i < init.length; i++) {
      vec[i] = new Complex(init[i].getReal(), init[i].getImag());
    }
  }
  
  /**
  * Normalizes the vector
  */
  public void norm() {
    double tot = 0;
    for (int i = 0; i < vec.length; i++) {
      tot += vec[i].square();
    }
    if (tot < 1 - tol || tot > 1 + tol) {
      for (int i = 0; i < vec.length; i++) {
        vec[i].div(tot);
      }
      System.out.printf("Normalized by a factor of %3.3f\n", tot);
    }
  }
  
  public int size() {
    return size;
  }
 
}
