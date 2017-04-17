//������ͼ�����������������ͳ��󷽷�
//����������Բ�����Σ������ε��������ʽ��ͬ���������ǵĸ���ķ�������ó��󷽷�
//���������ุ��
abstract class Graph{
	//�������󷽷�������������д
	abstract public double getArea();
}
//����Բ��,Ҫ��д���෽��
class Circle extends Graph{
	//��Բ�����ʱ����Ҫ�뾶
	private double r;
	//���ڲ���ֱ���ڵ��÷���ʱ�������ݣ�Ҫͨ�����췽���ڽ�����ʱ��������
	Circle(double r){
		//���������ʽ������ֵ�����ֶ�
		this.r = r;
	}
	//����Ҫ��д���෽�������Բ����б��븸�෽��һ��
	public double getArea(){
		return Math.PI * Math.pow(r,2);
	}
}
//����������
class Rectangle extends Graph{
	//����ε����ʱ����Ҫ���Ϳ�
	public double width;
	public double length;
	//��һ���Ǵ����޲ι��췽�������������ٸ��ֶθ�ֵ����ͨ��������÷���
	Rectangle(){
		//this.width = width;
		//this.length = length;
		
	}
	//����Ҫ��д���෽�������Բ����б��븸�෽��һ��
	public double getArea(){
		return width * length;
	}
}
//������������
class Triangle extends Graph{
	//���������������֪�������߷ֱ�ĳ���
	private double a;
	private double b;
	private double c;
	private double p = a + b + c;
	Triangle(double a,double b,double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	//����Ҫ��д���෽�������Բ����б��븸�෽��һ��
	public double getArea(){
		return Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}
}
//�����࣬��GraphTest
public class GraphTest {
	//����������
	public static void main(String[] args) {
		//����ͼ����Ķ��󣬵��ô��ι��췽��������getArea()����������
		Circle c = new Circle(6.3);
		double areaCircle = c.getArea();
		System.out.println(areaCircle);
		//���޲ι��췽������ͼ����Ķ���
		Rectangle e = new Rectangle();
		//ͨ��������ֶθ�ֵ
		e.width = 3;
		e.length = 5;
		//���������������������
		System.out.println(e.getArea());
	}
}
/*
С�᣺����������д����ĳ��󷽷�ʱ�����෽���Ĳ����б�Ҫ�븸���һ��
�������Ķ���������������йأ������ֶ��������ι��췽��
*/