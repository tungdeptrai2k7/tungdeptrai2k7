package game.physics;

import game.Vector2D;

public class BoxCollider {
    Vector2D anchor;
    Vector2D position; // vị trí hình chữ nhật (góc trên bên trái)
    int width; // chiều rộng hcn
    int height; // chiều cao hcn

    public BoxCollider() {
        this(new Vector2D(), new Vector2D(), 1, 1);
    }

    public BoxCollider(Vector2D position, Vector2D anchor , int width, int height) {
        this.position = position;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
    }

    public float top() {
        return this.position.y - this.anchor.y * this.height;
    }

    public float bot() {
        return this.top() + this.height;
    }

    public float left() {
        return this.position.x - this.anchor.x * this.width;
    }

    public float right() {
        return this.left() + this.width;
    }

    /**
     * @param other
     * @return true: nếu hình chữ nhật được gọi (this) có phần
     * giao với hình chữ nhật truyền vào (other)
     * @return false: nếu 2 hình chữ nhật ko giao nhau
     */
    public boolean intersects(BoxCollider other) {
        // TODO: 1. Triển khai phần code kiểm tra va chạm giữa 2 hình chữ nhật ở đây

        return this.bot() >= other.top()
                && this.top() <= other.bot()
                && this.left() <= other.right()
                && this.right() >= other.left();

    }
}
