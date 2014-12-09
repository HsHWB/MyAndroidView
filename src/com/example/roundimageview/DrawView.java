package com.example.roundimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class DrawView extends View {
	
	Paint mPaint;
	Context context = MainActivity.mainContext;
	public DrawView(Context context){
		super(context, null);
	}
	
	public DrawView(Context context, AttributeSet attrs){
		super(context, attrs);
		mPaint = new Paint();
	}
	
	@Override
	public void onDraw(Canvas canvas){
		super.onDraw(canvas);
		if(context != null){
			ImageView imageView = new ImageView(context);
			imageView.setImageResource(R.drawable.asd);
			Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
			Bitmap roundBitmap = getRoundBitmap(bitmap);
			
			Rect src = new Rect();// 这个是表示绘画图片的大小
	        Rect dst = new Rect();// 屏幕位置及尺寸
	        src.left = 0;
	        src.top = 0;
	        src.right = roundBitmap.getWidth();//这个是桌面图的宽度，
	        src.bottom = roundBitmap.getHeight();//这个是桌面图的高度的一半
	        dst.left = 0;
	        dst.top = 0;
	        dst.right = roundBitmap.getWidth();    //表示需绘画的图片的右上角
	        dst.bottom = roundBitmap.getHeight();    //表示需绘画的图片的右下角
	        canvas.drawBitmap(roundBitmap,src,dst,mPaint);
		}
	}
	
	public static Bitmap getRoundBitmap(Bitmap bitmap){
		
		int width = bitmap.getWidth();//圆形图片的宽
		int height = bitmap.getHeight();//圆形图片的长
		int r = 0;//正方形的边长
		
		if(width > height)//取最短的作为边长
			r = height;
		else 
			r = width;
		
		Bitmap backRound = Bitmap.createBitmap(width, height, Config.ARGB_8888);//构建一个bitmap
		Canvas canvas = new Canvas(backRound);//一个新的canvas，在backRound上面画图
		Paint paint = new Paint();
		paint.setAntiAlias(true);//设置边缘光滑，去掉锯齿
		RectF rect = new RectF(0, 0, r, r);//宽和长相等，即为正方形
		canvas.drawRoundRect(rect, r/2, r/2, paint);//通过制定的rect画一个圆角矩形，当圆角X轴方向的半径等于Y轴方向的半径且都为r/2时，画出来的圆角矩形及时圆形
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
		canvas.drawBitmap(bitmap, null, rect, paint);
		return backRound;
	}
}