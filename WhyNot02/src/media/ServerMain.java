package media;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.web.servlet.ModelAndView;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.VideoAttributes;
import it.sauronsoftware.jave.VideoSize;

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
					//fos.flush();
					len = is.read(buffer);
					if(len<0)
						break;
					System.out.println("len : "+len);
					fos.write(buffer,0,len);
				
				}
				System.out.println("��: "+datas+" kbps");
				fos.flush();
				fos.close();
				
				String[] fileNameE=fileName.split("[.]");//0: ���� ����, 1: ���� Ȯ����
				System.out.println(fileNameE.length);
				System.out.println(fileNameE[0]);
				System.out.println(fileNameE[1]);
        		if(fileNameE[1].equals("mp4"))//mp4�� �� �� ����, mp4�� �ƴϸ� ���ڵ��ؾ��ϴϱ�
        		{
        			return;
        			
        		}//mp4�� �ƴϸ� ���ڵ� ����
        		//� �����̵�, mp4�� ���ڵ�
        		System.out.println("���ڵ� ����");
        		String filedir="C:\\Users\\�����\\Desktop\\";
        		System.out.println("filedir : "+filedir);
        		File source = new File("C:\\Users\\�����\\Desktop\\"+fileName);
        		File target = new File("C:\\Users\\�����\\Desktop\\"+fileNameE[0]+".mp4");
        		AudioAttributes audio = new AudioAttributes();
        		VideoAttributes video = new VideoAttributes();
        		audio.setCodec("libmp3lame");
        		audio.setBitRate(new Integer(64000));
        		audio.setChannels(new Integer(1));
        		audio.setSamplingRate(new Integer(22050));
        		System.out.println("����� ���ڵ� �Ϸ�");
        		
        		//video.setCodec("flv");
        		video.setBitRate(new Integer(14745600));
        		//160000
        		video.setFrameRate(new Integer(15));
        		video.setSize(new VideoSize(400, 300));
        		System.out.println("���� ���ڵ� �Ϸ�");
        		EncodingAttributes attrs = new EncodingAttributes();
        		attrs.setFormat("mp4");
        		attrs.setAudioAttributes(audio);
        		attrs.setVideoAttributes(video);

        		Encoder encoder = new Encoder();
        		encoder.encode(source, target, attrs);
        		//���ڵ� ��!
        		System.out.println("d���ڵ� ��!");
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