/**
 * TreeData类用于表示树节点的数据
 */
public abstract class TreeData {
    private int pid; // 父节点id
    private int id; // 当前节点id
    private String content; // 节点内容
    private String image_path; // 图片路径

    /**
     * 默认构造方法，设置content为"新建节点"
     */
    public TreeData() {
        this.content = "新建节点";
    }

    /**
     * 构造方法，初始化节点id和父节点id，并设置content为"新建节点"
     * @param id 当前节点id
     * @param pid 父节点id
     */
    public TreeData(int id, int pid) {
        this.content = "新建节点";
        this.pid = pid;
        this.id = id;
    }

    /**
     * 构造方法，初始化节点id、父节点id和content
     * @param id 当前节点id
     * @param pid 父节点id
     * @param content 节点内容
     */
    public TreeData(int id, int pid, String content) {
        this(id, pid);
        this.content = content;
    }

    /**
     * 重写equals方法，比较两个TreeData对象的id是否相等
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            TreeData treeNode = (TreeData)obj;
            return this.id == treeNode.id;
        } else {
            return false;
        }
    }

    // getter和setter方法
    public int getPid() {
        return this.pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int nid) {
        this.id = this.id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage_path() {
        return this.image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
}
