
public abstract class TreeData {
    private int pid;
    private int id;
    private String content;
    private String image_path;

    public TreeData() {
        this.content = "新建节点";
    }

    public TreeData(int id, int pid) {
        this.content = "新建节点";
        this.pid = pid;
        this.id = id;
    }

    public TreeData(int id, int pid, String content) {
        this(id, pid);
        this.content = content;
    }

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
