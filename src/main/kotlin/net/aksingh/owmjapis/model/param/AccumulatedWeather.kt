/**************************************************************************************************
 * Copyright (c) 2013-2019 Ashutosh Kumar Singh <ashutosh@aksingh.net>                            *
 *                                                                                                *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this           *
 * software and associated documentation files (the "Software"), to deal in the Software without  *
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,     *
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the  *
 * Software is furnished to do so, subject to the following conditions:                           *
 *                                                                                                *
 * The above copyright notice and this permission notice shall be included in all copies or       *
 * substantial portions of the Software.                                                          *
 *                                                                                                *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING  *
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND     *
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,   *
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, *
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.        *
 **************************************************************************************************/

package net.aksingh.owmjapis.model.param

import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import java.util.*

data class AccumulatedWeather(
  @field:SerializedName("dateFromApi")
  private val dateFromApi: String? = null,

  @field:SerializedName("rain")
  val rain: Double? = null,

  @field:SerializedName("temp")
  val temp: Double? = null,

  @field:SerializedName("count")
  val count: Int? = null
) {

  var date: Date? = null
    get() {
      if (dateFromApi != null) {
        return Date(dateFromApi.toLong() * 1000L)
      }
      return null
    }

  fun hasDate(): Boolean = date != null

  fun hasRain(): Boolean = rain != null

  fun hasTemp(): Boolean = temp != null

  fun hasCount(): Boolean = count != null

  companion object Static {
    @JvmStatic
    fun fromJson(json: String): AccumulatedWeather {
      return GsonBuilder().create().fromJson(json, AccumulatedWeather::class.java)
    }

    @JvmStatic
    fun toJson(pojo: AccumulatedWeather): String {
      return GsonBuilder().create().toJson(pojo)
    }

    @JvmStatic
    fun toJsonPretty(pojo: AccumulatedWeather): String {
      return GsonBuilder().setPrettyPrinting().create().toJson(pojo)
    }
  }
}
