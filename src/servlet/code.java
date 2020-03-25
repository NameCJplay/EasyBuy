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
		int width = 100;// 图片的宽度
		int height = 20;// 图片的宽度
		// 生成验证码的图片
		// 1、创建图片缓冲区(就是一块内存)
		// 方便在这块内存中画出图片
		BufferedImage bi = 
			new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 2、准备向图片缓冲区中画图片
		// 2-1 获取画笔(就是用来画图片的对象)
		// Graphics就是画笔对象
		Graphics g = bi.getGraphics();
		
		// 3、给图片画出背景颜色（红色）
		g.setColor(Color.WHITE);
		// 使用画笔填充背景
		// 第一个参数指定起点的x坐标
		// 第二个参数指定起点的y坐标
		// 第三个参数指定要填充的宽度
		// 第四个参数指定要填充的高度
		g.fillRect(0, 0, width, height);
		
		// 4、给图片画个边框（绿色）
		g.setColor(Color.GREEN);
		// 画边框
		// 注意width-1和height-1避免重合
		g.drawRect(0, 0, width-1, height-1);
		
		// 随机生成验证码 a2Db
		Random rand = new Random();
		char one = 
			(char)(rand.nextInt(26) + 97);
		int two = rand.nextInt(10);
		char three = 
			(char)(rand.nextInt(26) + 65);
		char four = 
			(char)(rand.nextInt(26) + 97);
		// 将生成的4个字符串拼接成验证码字符串
		// 画入图片中
		String code = one + " " + two + " " + three + " " + four;
		// 将code画入到图片中(字符显示的颜色为红色)
		g.setColor(Color.RED);
		// 设置画笔的字体
		g.setFont(new Font("隶书", Font.BOLD, 20));
		// drawString用来画字符串
		g.drawString(code, 13, 18);
		
		// 给验证码画出10根干扰线
		g.setColor(Color.GRAY);
		for(int i = 1; i <= 10; i++){
			// 前面两个参数指定起点的x和y坐标
			// 前面两个参数指定终点的x和y坐标
			int x1 = rand.nextInt(width + 1);
			int x2 = rand.nextInt(width + 1);
			g.drawLine(x1, 0, x2, height);
		}
		
		// 保存生成的验证码到session
		String code1 = one + "" + two + "" + three + "" + four;
		request.getSession().setAttribute("mycode", code1);
		// 将生成的图片通过流发送给浏览器
		OutputStream out = 
			response.getOutputStream();
		// ImageIO是专门用来操作图片的一个帮助流
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
