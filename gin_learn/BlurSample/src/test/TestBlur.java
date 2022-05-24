package test;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class TestBlur {

	public static void main(String[] args) {
		//TestAllBlur();
		//TestRectBlur();
		TestDiagBlur();
	}

	// ȫͼģ��
	public static void TestAllBlur() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		Mat src = Imgcodecs.imread("src.jpg");
		Mat dst = new Mat();
		Imgproc.GaussianBlur(src, dst, new Size(51, 51), 0);

		Imgcodecs.imwrite("dst.jpg", dst);
	}

	// �ֲ�����ģ��
	public static void TestRectBlur() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		Mat src = Imgcodecs.imread("src.jpg");
		//�ײ���1/6ģ��
		Rect rect = new Rect(0, src.height() * 5 / 6, src.width(), src.height() / 6);
		// System.out.println(rect.toString());
		Mat dst = src.submat(rect);
		Imgproc.GaussianBlur(dst, dst, new Size(51, 51), 0);

		Imgcodecs.imwrite("dst.jpg", src);
	}

	// б��ģ��
	public static void TestDiagBlur() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		Mat src = Imgcodecs.imread("src.jpg");
		//�ײ���2/6бб���ײ���1/6
		double _h = (double)src.height()/(6.0* src.width());//�߶ȵĲ���ֵ
		for (int i = 0; i < src.width(); i++) {
			//���Ϊ1���߶ȵݼ��ľ���
			Rect rect = new Rect(i, (int) (2.0*src.height()/3.0 + i * _h), 1, (int) (src.height()/3.0 - i * _h));
			// System.out.println(rect.toString());
			Mat dst = src.submat(rect);
			Imgproc.GaussianBlur(dst, dst, new Size(51, 51), 0);
		}
		Imgcodecs.imwrite("dst.jpg", src);
	}
}
