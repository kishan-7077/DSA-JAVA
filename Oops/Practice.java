
class Complex {
    int real, imag;

    Complex(int r, int i) {
        this.real = r;
        this.imag = i;
    }

    void print() {
        if (real == 0 && imag == 0) {
            System.out.println(this.imag);
        } else if (imag < 0) {
            System.out.println(this.real + " - i" + this.imag * -1);
        } else {
            System.out.println(this.real + " + i" + this.imag);
        }
    }

    public static Complex add(Complex c1, Complex c2) {
        return new Complex((c1.real + c2.real), (c1.imag + c2.imag));
    }

    public static Complex diff(Complex c1, Complex c2) {
        return new Complex((c1.real - c2.real), (c1.imag - c2.imag));
    }

    public static Complex product(Complex c1, Complex c2) {
        return new Complex((c1.real * c2.real), (c1.imag * c2.imag));
    }
}

public class Practice {
    public static void main(String[] args) {
        Complex c1 = new Complex(-1, 0);
        Complex c2 = new Complex(1, 2);
        Complex res = Complex.add(c1, c2);
        Complex res1 = Complex.diff(c1, c2);
        Complex res2 = Complex.product(c1, c2);
        res.print();
        res1.print();
        res2.print();
    }
}
