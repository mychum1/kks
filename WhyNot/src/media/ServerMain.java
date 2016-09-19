package media;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain implements Runnable{
	
	public void run() {
			try {
				ServerSocket ss = new ServerSocket(12345);
				System.out.println("�������� �����~!");
				Socket client = ss.accept();
				System.out.println(client.getInetAddress()+ " ���ӵ�..");
				InputStream is = client.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				//C:\\Users\\�����\\Desktop\\WhyNot_02\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\WhyNot\\video\\
				String upDir = "C:\\Users\\�����\\Desktop\\";
				FileOutputStream fos = null;
				
				
				long data = dis.readLong();
				String fileName = dis.readUTF();
				File file = new File(fileName);
				System.out.println("���������� �޾ƿ� ���� ���� : "+fileName);
				System.out.println("���Ϲ޾ƿ�����..");
				fos = new FileOutputStream(upDir+fileName);
				
				long datas = data;
				byte[] buffer = new byte[1024];
				int len;
				
				for(;data>=0;data--){
					len = is.read(buffer);
					fos.write(buffer,0,len);
				}
				System.out.println("��: "+datas+" kbps");
				fos.flush();
				fos.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerMain sm = new ServerMain();
		Thread t1 = new Thread(sm);
		t1.start();
	}

}