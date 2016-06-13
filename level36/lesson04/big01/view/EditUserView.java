package com.javarush.test.level36.lesson04.big01.view;

import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;

/**
 * Created by Flex on 04.04.2016.
 */
public class EditUserView implements View
{
    private Controller controller;

    @Override
    public void refresh(ModelData modelData)
    {
        System.out.println("User to be edited:");

            System.out.print("    ");
            System.out.println(modelData.getActiveUser().toString());
        System.out.println("===================================================");

    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void fireEventUserDeleted(long id)
    {
        controller.onUserDelete(id);
    }

    public void fireEventUserChanged(String name, long id, int level)
    {
        controller.onUserChange(name, id, level);
    }
}
