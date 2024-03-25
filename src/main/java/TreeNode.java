
//  TreeNode类表示树节点，继承自TreeData类
import  java.util.ArrayList;
import  java.util.Iterator;
import  java.util.List;

public  class  TreeNode  extends  TreeData  {
    private  static  TreeNode  root;  //  根节点静态变量
    private  List<TreeNode>  children  =  new  ArrayList();  //  子节点列表
    private  int  x;  //  x坐标
    private  int  y;  //  y坐标
    private  int  order;  //  排序
    private  Shape  shape;  //  形状
    private  float  left;  //  左边距
    private  float  top;  //  顶部距离
    private  boolean  click  =  false;  //  点击状态
    private  BorderStyle  borderStyle;  //  边界样式
    private  WordColor  wordColor;  //  文字颜色
    private  Status  status;  //  状态

    //  构造方法，初始化id和pid，并设置默认的边界样式、文字颜色、状态
    public  TreeNode(int  id,  int  pid)  {
        super(id,  pid);
        this.borderStyle  =  BorderStyle.SOLID;
        this.wordColor  =  WordColor.BLACK;
        this.status  =  Status.LOW;
    }

    //  无参构造方法，默认设置边界样式、文字颜色、状态
    public  TreeNode()  {
        this.borderStyle  =  BorderStyle.SOLID;
        this.wordColor  =  WordColor.BLACK;
        this.status  =  Status.LOW;
    }

    //  获取根节点
    public  static  TreeNode  getRoot()  {
        return  root;
    }

    //  设置根节点
    public  static  void  setRoot(TreeNode  root)  {
        TreeNode.root  =  root;
    }

    //  获取x坐标
    public  int  getX()  {
        return  this.x;
    }

    //  设置x坐标
    public  void  setX(int  x)  {
        this.x  =  x;
    }

    //  获取y坐标
    public  int  getY()  {
        return  this.y;
    }

    //  设置y坐标
    public  void  setY(int  y)  {
        this.y  =  y;
    }

    //  获取排序
    public  int  getOrder()  {
        return  this.order;
    }

    //  设置排序
    public  void  setOrder(int  order)  {
        this.order  =  order;
    }

    //  获取形状
    public  Shape  getShape()  {
        return  this.shape;
    }

    //  设置形状
    public  void  setShape(Shape  shape)  {
        this.shape  =  shape;
    }

    //  获取边界样式
    public  BorderStyle  getBorderStyle()  {
        return  this.borderStyle;
    }

    //  设置边界样式
    public  void  setBorderStyle(BorderStyle  borderStyle)  {
        this.borderStyle  =  borderStyle;
    }

    //  获取文字颜色
    public  WordColor  getWordColor()  {
        return  this.wordColor;
    }

    //  设置文字颜色
    public  void  setWordColor(WordColor  wordColor)  {
        this.wordColor  =  wordColor;
    }

    //  获取状态
    public  Status  getStatus()  {
        return  this.status;
    }

    //  设置状态
    public  void  setStatus(Status  status)  {
        this.status  =  status;
    }

    //  获取左边距
    public  float  getLeft()  {
        return  this.left;
    }

    //  设置左边距
    public  void  setLeft(float  left)  {
        this.left  =  left;
    }

    //  获取顶部距离
    public  float  getTop()  {
        return  this.top;
    }

    //  设置顶部距离
    public  void  setTop(float  top)  {
        this.top  =  top;
    }

    //  获取点击状态
    public  boolean  isClick()  {
        return  this.click;
    }

    //  设置点击状态
    public  void  setClick(boolean  click)  {
        this.click  =  click;
    }

    //  获取子节点列表
    public  List<TreeNode>  getChildren()  {
        return  this.children;
    }

    //  设置子节点列表
    public  void  setChildren(List<TreeNode>  children)  {
        this.children  =  children;
    }

}

//  文字颜色枚举
enum  WordColor  {
    BLACK,
    RED,
    BLUE,
    YELLOW;
}

//  状态枚举
enum  Status  {
    LOW,
    MEDIUM,
    HIGH;
}

//  形状枚举
enum  Shape  {
    CIRCLE,
    RECTANGLE;
}

//  边界样式枚举
enum  BorderStyle  {
    SOLID,
    DASHED,
    DOTTED,
    ARROW;
}