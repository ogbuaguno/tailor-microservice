package ng.com.soh.tailor.ms.dao;

import ng.com.soh.ms.core.model.Permission;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;


/**
 * Created by Blurryface on 10/26/17.
 */

public class PermissionDaoTest extends AbstractDaoTest{

    @Autowired
    private PermissionDao permissionDao;

    @Test
    public void create(){
        Permission permission = new Permission();
        permission.setName("View Shopping");
        permission.setDescription("View all items in the shopping cart");
        permission = permissionDao.create(permission);

        Assert.assertNotNull(permission);
        Assert.assertTrue(permission.getId() > 0);
    }

    @Test
    public void find(){
        Permission permission = new Permission();
        permission.setName("View Shopping 2");
        permission.setDescription("View all items in the shopping cart");
        permission = permissionDao.create(permission);

        Permission newPermission = permissionDao.find(permission.getId());

        Assert.assertNotNull(newPermission);
        Assert.assertEquals(newPermission.getName(), "View Shopping 2");
    }

    @Test(expected = DuplicateKeyException.class)
    public void findFail(){
        Permission permission = new Permission();
        permission.setName("View Shopping");
        permission.setDescription("View all items in the shopping cart");
        permission = permissionDao.create(permission);

        Permission newPermission = permissionDao.find(permission.getId());

        Assert.assertNotNull(newPermission);
        Assert.assertEquals(newPermission.getName(), "View Shopping 2");
    }

    @Test
    public void update(){
        Permission permission = new Permission();
        permission.setName("Create Measurement");
        permission.setDescription("User can create their own measurements");
        permission = permissionDao.create(permission);

        permission.setName("Edit Measurement");
        permission = permissionDao.update(permission);

        Assert.assertNotNull(permission);
        Assert.assertEquals(permission.getName(), "Edit Measurement");
    }

    @AfterClass
    public static void tearDown(){
        jdbcTemplate.execute("delete from permissions where id > 0");
    }

}
