//���󣺲�����Ԫ�������һ����վ��1��065�����ݣ�ÿҳֻ����ʾ20������Ӧ�����ö���ҳ��
//����һ���࣬��Page
class Page 
{
	//����������
	public static void main(String[] args) 
	{
		//������������վ��������
		int totalData = 1065;
		//������������վÿҳ����ʾ������
		int eachPage = 20;
		//������������վ����ҳ��
		int totalPage = totalData / eachPage;
		//������Ŀ����������������ݳ���ÿҳ������������ʣ�µ�����Ҫ��������һҳ����ʾ��������������򷵻ؽ��
		totalPage = totalData % eachPage != 0 ? totalPage + 1 : totalPage;
		//��ӡ���
		System.out.println(totalPage);
	}
}
/*
С�᣺X ? Y : Z  ,XΪboolean���ͱ��ʽ����Ϊtrue������Y��Ϊfalse������Z��Y��Z�͸�ֵ������ߵı���Ҫ��������һ��
*/