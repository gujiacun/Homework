//�����ж�һ�����Բ�Ĺ�ϵ(��Բ��,Բ����,Բ��).
//������Բ�İ뾶Ϊ5��Բ������Ϊ(3,2),��A����Ϊ(6,8),Ҫ�Ƚϵ�A��Բ�ĵľ�����Բ�뾶�Ĵ�С��ϵ
//�ֱ𴴽�һ�������Բ�࣬�����������������ݵ�������У��ٰѵ�������뵽Բ�����У��ж�
//��������
class Point{
	//�����ֶΣ���ʾ�ᣬ�����꣬Ҫ����javabean�淶
	private int x;
	private int y;
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	//��set/get��������˽���ֶ�
	public int getX(){
		return x;
	}
	public void setX(int x){
		//this���ε�x��ʾ��ǰ�����ⷽ���Ķ��󣬰Ѿֲ�����x�����ֶ�x
		this.x = x;
	}
	//��set/get��������˽���ֶ�
	public int getY(){
		return y;
	}
	public void setY(int y){
		//this���ε�x��ʾ��ǰ�����ⷽ���Ķ��󣬰Ѿֲ�����x�����ֶ�x
		this.y = y;
	}
}
//����Բ��
class Circle{
	//�����ֶΣ���ʾ�ᣬ�����꣬Ҫ����javabean�淶
	private int x0;
	private int y0;
	public Circle(int x,int y){
		this.x0 = x;
		this.y0 = y;
	}
	//�����ֶΣ���ʾ��A��Բ�ĵľ��룬�ݴ���Բ�뾶�Ƚ�
	public int distance;
	public int r = 5;
	//��set/get��������˽���ֶ�
	public int getX0(){
		return x0;
	}
	public void setX0(int x0){
		//this���ε�x��ʾ��ǰ�����ⷽ���Ķ��󣬰Ѿֲ�����x�����ֶ�x
		this.x0 = x0;
	}
	//��set/get��������˽���ֶ�
	public int getY0(){
		return y0;
	}
	public void setY0(int y0){
		//this���ε�x��ʾ��ǰ�����ⷽ���Ķ��󣬰Ѿֲ�����x�����ֶ�x
		this.y0 = y0;
	}
	//���������������A��Բ�ĵľ���
	public double calculate(Point p){
		//ע������
		double distance = Math.sqrt(Math.pow(p.getX() - x0,2) + Math.pow(p.getY() - y0,2));
		return distance;
	}
	//��if-else if-else�ṹ��������1��ʾ����Բ�ڣ�0��ʾԲ�ϣ�-1��ʾԲ��
	public int judge(){
		if(r > distance){
			return 1;
		}else if (r < distance){
			return -1;
		}else{
			return 0;
		}
	}
}
//����������
public class PointTest {
	//���������������
	public static void main(String[] args) {
		//ͨ����������Ķ�����������,��A����Ϊ(6,8)
		Point p = new Point(6,8);
		//ͨ������Բ��Ķ�����������,Բ������Ϊ(3,2)
		Circle c = new Circle(3,2);
		//����Բ��ķ��������A��Բ�ĵľ���
		double dis = c.calculate(p);
		//����judge�������ж�Բ�����A�ľ��룬�����������ܽ��
		int result = c.judge();
		//������
		System.out.println(result);
	}
}
/*
С�᣺�渴�ӡ�����Ҫѧ�������ϸ����ת��Ϊ����˼·���Զ�������ƣ�ÿ��ֻ����ƽ��˼����
��������ʵ��
ÿ�δ�����������ڵ��ù��췽���������ڴ����������������ʱ��Ҫ�ֶ������д������췽��
*/