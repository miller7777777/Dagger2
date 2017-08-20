package ru.levelp.dagger2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import com.bumptech.glide.RequestManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import ru.levelp.dagger2.api.Car
import ru.levelp.dagger2.api.CarService
import ru.levelp.dagger2.api.CarsAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var imageRequestManager: RequestManager
    @Inject lateinit var carService: CarService

    private val subscriptions = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {

        appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadCars()
    }

    override fun onDestroy() {
        super.onDestroy()
        subscriptions.dispose()
    }

    private fun loadCars() {
        subscriptions.add(carService.cars()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {(cars) -> setUpCars(cars) },
                        { error -> Log.e(TAG, "failed to load cars", error)}
                ))
    }

    private fun setUpCars(cars: List<Car>){

        carList.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayout.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(this@MainActivity, LinearLayout.VERTICAL))
            adapter = CarsAdapter(cars, imageRequestManager)
        }



    }



    private companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }
}
