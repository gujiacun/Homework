//���󣺲���if - else if -else
//����һ���࣬��IfElseIfElseTest
class IfElseIfElseTest {
	//����һ��������
	public static void main(String[] args) {
		/*С�����ԣ����ĵ���78�֣���ѧ����88�֣�Ӣ�����911�֣��Ŀ���������߷֣�
		������ʹ�ö�·��������ţ������ķ���ȥ����ѧ��Ӣ������Ƚϣ����Ϊtrue����������߷֡�
		�����Ϊfalse�������Ĳ�����߷֣���ʱֻ��Ƚ�ʣ�µ����Ʒ���������ľ�����߷�
		*/
		int chinese = 78;
		int math = 88;
		int english = 91;
		if(chinese >= math && chinese >= english){
			System.out.println("��������߷֣�����Ϊ��" + chinese);
		}else if(math >= english){
			System.out.println("��ѧ����߷֣�����Ϊ��" + math);
		}else{
			System.out.println("Ӣ������߷֣�����Ϊ��" + english);
		}
	}
}
/*
С�᣺���������ʽ1Ϊtrue��ִ������ִ����1��ִ�������뿪if��䣬���ٹ�if����������䡣
��Ϊfalse�����ж�else if����������ʽ2���ٸ��ݽ�������Ƿ�ִ����䡣else�����Ϊ�����ϵ����б��ʽ��Ϊfalseʱ����Ҫִ�еĴ���顣����ʡ��
*/