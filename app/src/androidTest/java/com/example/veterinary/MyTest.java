package com.example.veterinary;

import android.content.Context;

import androidx.room.Room;

import com.example.veterinary.data.Pet;
import com.example.veterinary.room.AppDatabase;
import com.example.veterinary.room.DaoPets;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import androidx.test.platform.app.InstrumentationRegistry;

@RunWith(JUnit4.class)
public class MyTest {
    private AppDatabase db;
    public DaoPets daoPets;
    public Context context;

    @Before
    public void createDb(){
        db=Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().getTargetContext(),
                AppDatabase.class).build();
        daoPets=db.daoPets();
    }

    @Test
    public void testing(){
        int sum= 5+3;
        assertTrue("• NO NO NO ", sum > 4);
    }

    @Test
    public void saveName() throws InterruptedException {
        Pet pet=new Pet();
        pet.setPetId(1);
        pet.setName("Tomm");
        pet.setPostname("Petty");
        pet.setAge("4");

        Thread thread=new Thread(() ->
            daoPets.save(pet)
        );
        thread.start();
        thread.join();

        daoPets.load().subscribeOn(Schedulers.io()) .observeOn(AndroidSchedulers.mainThread())
        .subscribe((list)->{
            assertNotNull(list.size());
            assertTrue(list.size()>0);
        });

    }
}
