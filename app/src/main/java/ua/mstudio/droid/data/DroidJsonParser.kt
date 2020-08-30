package ua.mstudio.droid.data

import android.content.Context
import com.beust.klaxon.JsonReader
import com.beust.klaxon.Klaxon
import ua.mstudio.droid.model.DroidVersion
import java.io.IOException
import java.io.InputStream
import java.io.StringReader
import java.nio.charset.Charset

class DroidJsonParser(ctx: Context) {

    val context = ctx

    fun loadJSONFromAsset(): String? {
        var json: String? = null
        json = try {
            val d: InputStream = context.assets.open("droid.json")
            val size: Int = d.available()
            val buffer = ByteArray(size)
            d.read(buffer)
            d.close()
            String(buffer, Charset.defaultCharset())
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    fun getArrayData() : ArrayList<DroidVersion> {
        val klaxon = Klaxon()
        val data = loadJSONFromAsset()
        val productArray = arrayListOf<DroidVersion>()
        JsonReader(StringReader(data)).use { reader ->
            reader.beginArray {
                while (reader.hasNext()) {
                    val product = klaxon.parse<DroidVersion>(reader)
                    productArray.add(product!!)
                }
            }
        }
        return productArray
    }
}