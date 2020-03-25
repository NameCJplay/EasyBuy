package servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class code
 */
public class code extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public code() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int width = 100;// ͼƬ�Ŀ��
		int height = 20;// ͼƬ�Ŀ��
		// ������֤���ͼƬ
		// 1������ͼƬ������(����һ���ڴ�)
		// ����������ڴ��л���ͼƬ
		BufferedImage bi = 
			new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 2��׼����ͼƬ�������л�ͼƬ
		// 2-1 ��ȡ����(����������ͼƬ�Ķ���)
		// Graphics���ǻ��ʶ���
		Graphics g = bi.getGraphics();
		
		// 3����ͼƬ����������ɫ����ɫ��
		g.setColor(Color.WHITE);
		// ʹ�û�����䱳��
		// ��һ������ָ������x����
		// �ڶ�������ָ������y����
		// ����������ָ��Ҫ���Ŀ��
		// ���ĸ�����ָ��Ҫ���ĸ߶�
		g.fillRect(0, 0, width, height);
		
		// 4����ͼƬ�����߿���ɫ��
		g.setColor(Color.GREEN);
		// ���߿�
		// ע��width-1��height-1�����غ�
		g.drawRect(0, 0, width-1, height-1);
		
		// ���������֤�� a2Db
		Random rand = new Random();
		char one = 
			(char)(rand.nextInt(26) + 97);
		int two = rand.nextInt(10);
		char three = 
			(char)(rand.nextInt(26) + 65);
		char four = 
			(char)(rand.nextInt(26) + 97);
		// �����ɵ�4���ַ���ƴ�ӳ���֤���ַ���
		// ����ͼƬ��
		String code = one + " " + two + " " + three + " " + four;
		// ��code���뵽ͼƬ��(�ַ���ʾ����ɫΪ��ɫ)
		g.setColor(Color.RED);
		// ���û��ʵ�����
		g.setFont(new Font("����", Font.BOLD, 20));
		// drawString�������ַ���
		g.drawString(code, 13, 18);
		
		// ����֤�뻭��10��������
		g.setColor(Color.GRAY);
		for(int i = 1; i <= 10; i++){
			// ǰ����������ָ������x��y����
			// ǰ����������ָ���յ��x��y����
			int x1 = rand.nextInt(width + 1);
			int x2 = rand.nextInt(width + 1);
			g.drawLine(x1, 0, x2, height);
		}
		
		// �������ɵ���֤�뵽session
		String code1 = one + "" + two + "" + three + "" + four;
		request.getSession().setAttribute("mycode", code1);
		// �����ɵ�ͼƬͨ�������͸������
		OutputStream out = 
			response.getOutputStream();
		// ImageIO��ר����������ͼƬ��һ��������
		ImageIO.write(bi, "jpg", out);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
