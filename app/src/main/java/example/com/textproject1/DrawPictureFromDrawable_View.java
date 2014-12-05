package example.com.textproject1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * @author hs
 * android自定义View，重写构造函数、 onDraw， (onMeasure)等函数
 * 如果自定义的View需要有自定义的属性，需要在values下建立attrs.xml。在其中定义你的属性。
 * 在使用到自定义View的xml布局文件中需要加入xmlns:前缀="http://schemas.android.com/apk/res/你的自定义View所在的包路径".
 * 在使用自定义属性的时候，使用前缀：属性名，如my:textColor="#FFFFFFF"。
 */
public class DrawPictureFromDrawable_View extends View implements GestureDetector.OnGestureListener{
    /**
     * 定义画笔
     */
    Paint mPaint;//画笔,包含了画几何图形、文本等的样式和颜色信息
    Context context = null;
    DisplayMetrics displayMetrics = NewScrollView_Activity.displayMetrics_Scroll;
    GestureDetector detector;
    int screenWidthDip = (int)(displayMetrics.widthPixels);//屏幕宽
    int screenHeightDip = (int)(displayMetrics.heightPixels);//屏幕长
    Bitmap bitmap1 = null;
    /**
     * 获取屏幕的长和宽
     */
    public DrawPictureFromDrawable_View(Context context){
        this(context, null);
//        this.context = context;

        setWillNotDraw(false);
    }

    public DrawPictureFromDrawable_View(Context context, AttributeSet attrs){
        super(context, attrs);
        this.context = context;

        setWillNotDraw(false);
        System.out.println("setWillNotDraw(false)");

        mPaint = new Paint();
        /**
         * TypedArray是一个数组容器,在使用完成后，一定要调用recycle方法,否则这次的设定会对下次的使用造成影响
         * 在xml 文件里定义控件的属性，我们已经习惯了android:attrs="" ,那么我们能
         * 不能定义自己的属性能，比如:test:attrs="" 呢？答案是肯定的.
         */
        TypedArray tA = context.obtainStyledAttributes(attrs, R.styleable.DrawPictureFromDrawable_View);
        int textColor = tA.getColor(R.styleable.DrawPictureFromDrawable_View_listColor2, 0XFF00FF00); //提供默认值，放置未指定
        float textSize = tA.getDimension(R.styleable.DrawPictureFromDrawable_View_listSize2, 36);
        mPaint.setTextSize(textSize);
        mPaint.setColor(textColor);
        tA.recycle();

        /**
         * 创建view的手势
         */
        detector = new GestureDetector(getContext(), this);
    }

    /**
     * @param canvas
     * Canvas中含有很多画图的接口，利用这些接口，我们可以画出我们想要的图形
     */
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        System.out.println("onDraw onDraw");

        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.sucai1);
        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();

        float density = displayMetrics.density;//获取屏幕密度（像素比例）
        int densityDPI = displayMetrics.densityDpi;//屏幕密度（每寸像素）
        float xdpi = displayMetrics.xdpi;
        float ydpi = displayMetrics.ydpi;
        System.out.println("xdpi"+xdpi+"    ydpi"+ydpi);
        System.out.println("屏幕长："+screenHeightDip+"     屏幕宽："+screenWidthDip);
        bitmap1 = resizeBitmap(bitmap,screenWidthDip,screenHeightDip);
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
            float scaleHeight = ((float) newHeight/6) / height;
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);
            Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width,
                    height, matrix, false);
            return resizedBitmap;
        } else {
            return null;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
       setMeasuredDimension(screenWidthDip, screenHeightDip/5);
//        setMeasuredDimension(screenWidthDip,500);
    }

    @Override
    public boolean onDown(MotionEvent e){
//        System.out.println("单击");
//        Toast.makeText(context,"单击",Toast.LENGTH_SHORT).show();

        return true;
    }

    /**
     * 手势onScroll和onFling区分：http://blog.csdn.net/yuliyige/article/details/12655895
     */
    @Override
    public  boolean onScroll(MotionEvent e, MotionEvent e2, float distanceX, float distanceY){
//        int dx = (int)(e2.getX() - e.getX());
//        int dy = (int)(e2.getY() - e.getY());
//        System.out.println("滑动");
//        if (Math.sqrt(Math.pow(Math.abs(dx),2)+Math.pow(Math.abs(dy),2)) > 200) {
//            Toast.makeText(context, "滑动", Toast.LENGTH_SHORT).show();
//        }
        return true;
    }
    @Override
    public boolean onSingleTapUp(MotionEvent e){
        return false;
    }
    @Override
    public void onShowPress(MotionEvent e){}
    @Override
    public void onLongPress(MotionEvent e){}
    @Override
    public boolean onFling(MotionEvent e, MotionEvent e2, float velocityX, float velocityY){
//        int dx = (int)(e2.getX() - e.getX());
//        int dy = (int)(e2.getY() - e.getY());
//        if (Math.sqrt(Math.pow(Math.abs(dx),2)+Math.pow(Math.abs(dy),2)) > 500) {
//            Toast.makeText(context, "onFling", Toast.LENGTH_LONG).show();
//            System.out.println("onFling");
//        }
        return true;
    }

    /**
     * 这个方法用来让View接受触控，让GestureDetector去处理
     * @param e
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent e){
        detector.onTouchEvent(e);
        return true;
    }
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent e){
//        return detector.onTouchEvent(e);
//    }
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