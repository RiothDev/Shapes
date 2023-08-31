import java.util.*;

class Program {
    public interface IShape {
        public double getArea();
        public double getPerimeter();

        public void ask(Scanner scan);
    }

    public static class Square implements IShape {
        private double length;

        @Override
        public void ask(Scanner scan) {
            System.out.print("Longitud: ");
            this.length = scan.nextDouble();
        }

        @Override
        public double getArea() {
            return (this.length * this.length);
        }

        @Override
        public double getPerimeter() {
            return (this.length * 4);
        }
    }

    public static class Triangle implements IShape {
        private double base, height, side1, side2;

        @Override
        public void ask(Scanner scan) {
            System.out.print("Base: ");
            this.base = scan.nextDouble();

            System.out.print("Altura: ");
            this.height = scan.nextDouble();

            System.out.print("Primer lado: ");
            this.side1 = scan.nextDouble();

            System.out.print("Segundo lado: ");
            this.side2 = scan.nextDouble();
        }

        @Override
        public double getArea() {
            return (base * height);
        }

        @Override
        public double getPerimeter() {
            return (base + side1 + side2);
        }
    }

    public static class Rectangle implements IShape {
        private double side1, side2;

        @Override
        public void ask(Scanner scan) {
            System.out.print("Primer lado: ");
            this.side1 = scan.nextDouble();

            System.out.print("Segundo lado: ");
            this.side2 = scan.nextDouble();
        }

        @Override
        public double getArea() {
            return (side1 * side2);
        }

        @Override
        public double getPerimeter() {
            return (side1 + side2);
        }
    }

    public static void init(Scanner scan) {
        System.out.print("1 - Cuadrado\n2 - Triángulo\n3 - Rectángulo\n4 - Finalizar\n> ");
        int option = scan.nextInt();

        switch(option) {
            case 1:
                Square newSquare = new Square();
                newSquare.ask(scan);

                System.out.println("\nÁrea: " + Double.toString(newSquare.getArea()) + "\nPerímetro: " + Double.toString(newSquare.getPerimeter()) + "\n");

                init(scan);
                break;
            
            case 2:
                Triangle newTriangle = new Triangle();
                newTriangle.ask(scan);

                System.out.println("\nÁrea: " + Double.toString(newTriangle.getArea()) + "\nPerímetro: " + Double.toString(newTriangle.getPerimeter()) + "\n");

                init(scan);
                break;

            case 3:
                Rectangle newRectangle = new Rectangle();
                newRectangle.ask(scan);

                System.out.println("\nÁrea: " + Double.toString(newRectangle.getArea()) + "\nPerímetro: " + Double.toString(newRectangle.getPerimeter()) + "\n");

                init(scan);
                break;
            
            case 4:
                return;

            default:
                System.out.println("Figura incorrecta");
                init(scan);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        init(scan);
        scan.close();
    }
}