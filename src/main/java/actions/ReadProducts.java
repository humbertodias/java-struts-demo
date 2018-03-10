package actions;

import com.opensymphony.xwork2.Action;
import control.ProductDAO;
import java.util.ArrayList;
import java.util.List;
import model.Product;

public class ReadProducts {

    private List<Product> list = new ArrayList<>();

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public String execute() {
        this.list = ProductDAO.findAll();
        return Action.SUCCESS;
    }
}
