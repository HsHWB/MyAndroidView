package example.com.textproject1;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author hs
 * android自定义View，重写构造函数、 onDraw， (onMeasure)等函数
 * 如果自定义的View需要有自定义的属性，需要在values下建立attrs.xml。在其中定义你的属性。
 * 在使用到自定义View的xml布局文件中需要加入xmlns:前缀="http://schemas.android.com/apk/res/你的自定义View所在的包路径".
 * 在使用自定义属性的时候，使用前缀：属性名，如my:textColor="#FFFFFFF"。
 */
public class NewListView2 extends View {
    /**
     * 定义画笔
     */
    Paint mPaint;//画笔,包含了画几何图形、文本等的样式和颜色信息
    Context context = null;
    DisplayMetrics displayMetrics = Message.displayMetrics;
    /**
     * 获取屏幕的长和宽
     */
    public NewListView2(Context context){
        super(context);
        this.context = context;
    }

    public NewListView2(Context context, AttributeSet attrs){
        super(context, attrs);
        this.context = context;
        mPaint = new Paint();
        /**
         * TypedArray是一个数组容器,在使用完成后，一定要调用recycle方法,否则这次的设定会对下次的使用造成影响
         * 在xml 文件里定义控件的属性，我们已经习惯了android:attrs="" ,那么我们能
         * 不能定义自己的属性能，比如:test:attrs="" 呢？答案是肯定的.
         */
        TypedArray tA = context.obtainStyledAttributes(attrs, R.styleable.NewListView2 );
        int textColor = tA.getColor(R.styleable.NewListView2_listColor2, 0XFF00FF00); //提供默认值，放置未指定
        float textSize = tA.getDimension(R.styleable.NewListView2_listSize2, 36);
        mPaint.setTextSize(textSize);
        mPaint.setColor(textColor);
        tA.recycle();
    }

    /**
     * @param canvas
     * Canvas中含有很多画图的接口，利用这些接口，我们可以画出我们想要的图形
     */
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.sucai1);
        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
//        Rect src = new Rect();// 这个是表示绘画图片的大小
//        Rect dst = new Rect();// 屏幕位置及尺寸
//        src.left = 0;
//        src.top = 0;
//        src.right = bitmap.getWidth();//这个是桌面图的宽度，
//        src.bottom = bitmap.getHeight();//这个是桌面图的高度的一半
//        dst.left = 0;
//        dst.top = 0;
//        dst.right = bitmap.getWidth();    //表示需绘画的图片的右上角
//        dst.bottom = bitmap.getHeight();    //表示需绘画的图片的右下角

        float density = displayMetrics.density;//获取屏幕密度（像素比例）
        int densityDPI = displayMetrics.densityDpi;//屏幕密度（每寸像素）
        float xdpi = displayMetrics.xdpi;
        float ydpi = displayMetrics.ydpi;
        System.out.println("xdpi"+xdpi+"    ydpi"+ydpi);
        int screenWidthDip = (int)(displayMetrics.widthPixels);//屏幕宽
        int screenHeightDip = (int)(displayMetrics.heightPixels);//屏幕长
        System.out.println("屏幕长："+screenHeightDip+"     屏幕宽："+screenWidthDip);
        Bitmap bitmap1 = resizeBitmap(bitmap,screenWidthDip,screenHeightDip);
        Rect src = new Rect();// 这个是表示绘画图片的大小
        Rect dst = new Rect();// 屏幕位置及尺寸
        src.left = 0;
        src.top = 0;
        src.right = bitmap1.getWidth();//这个是桌面图的宽度，
        src.bottom = bitmap1.getHeight();//这个是桌面图的高度的一半
        dst.left = 0;
        dst.top = 0;
        dst.right = bitmap1.getWidth();    //表示需绘画的图片的右上角
        dst.bottom = bitmap1.getHeight();    //表示需绘画的图片的右下角
        canvas.drawBitmap(bitmap1,src,dst,mPaint);
        src = null;
        dst = null;
    }
    public static Bitmap resizeBitmap(Bitmap bitmap, int w, int h) {
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int newWidth = w;
            int newHeight = h;
            float scaleWidth = ((float) newWidth) / width;
            float scaleHeight = ((float) newHeight/3) / height;
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);
            Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width,
                    height, matrix, false);
            return resizedBitmap;
        } else {
            return null;
        }
    }


}
/**
 创建你自己想要大小的 bitmap

 public static Bitmap resizeBitmap(Bitmap bitmap, int w, int h) {
 if (bitmap != null) {
 int width = bitmap.getWidth();
 int height = bitmap.getHeight();
 int newWidth = w;
 int newHeight = h;
 float scaleWidth = ((float) newWidth) / width;
 float scaleHeight = ((float) newHeight) / height;
 Matrix matrix = new Matrix();
 matrix.postScale(scaleWidth, scaleHeight);
 Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width,
 height, matrix, true);
 return resizedBitmap;
 } else {
 return null;
 }
 }
 public static Bitmap resizeBitmap(String path,int  width,int height){
 BitmapFactory.Options options = new BitmapFactory.Options();
 options.inJustDecodeBounds = true;
 options.outWidth = width;
 options.outHeight = height;

 Bitmap bmp = BitmapFactory.decodeFile(path, options);
 options.inSampleSize = options.outWidth / height;
 options.inJustDecodeBounds = false;
 bmp = BitmapFactory.decodeFile(path, options);
 return bmp;
 }
 */