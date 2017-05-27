/*
 * Copyright 2017 GcsSloop
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Last modified 2017-05-28 02:22:26
 *
 * GitHub: https://github.com/GcsSloop
 * WeiBo: http://weibo.com/GcsSloop
 * WebSite: http://www.gcssloop.com
 */

package com.gcssloop.kotlindemo.activitys

import com.gcssloop.kotlindemo.R
import com.gcssloop.kotlindemo.base.BaseActivity

class DataTypeActivity : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_text

    override fun create() {
        /*
        基础的数据类型和定义方式
        Kotlin 和 Java 语言一样，有着相同基本数据类型
        ====================
         Type   | Bit width
        --------------------
         Double | 64
         Float  | 32
         Long   | 64
         Int    | 32
         Short  | 16
         Byte   | 8
        --------------------
         Char
         String
         Boolean
         Array
        ====================
        */

        // 变量和常量
        // var 表示变量，val 表示常量
        // 下面是定义变量和常量
        var a = 1.0
        val b = 2

        // 类型自动推断
        // 和 Java 不同的是，Kotlin 不需要指定变量类型，系统会根据初始数据自动推断出数据类型
        // 但 Kotlin 的变量依旧是静态类型，例如，变量 a 是一个 Double，就不能再次赋值为 String

        // 指定数据类型
        // 由于 Kotlin 是根据值来推断数据类型的，所以一般情况下变量必须赋初值
        // 假如不想赋初值，则可以指定其类型，指定方式如下(var 变量名:类型)
        var c: String

        // 类型转换
        // 类型转换需要明确表示
        var d: Int = 1
        var e: Double = d.toDouble()

        // 如果低精度和高精度相加，结果为高精度
        var f = 1L + 2 // Long + Int => Long

        // 多行文本
        var g = """
        多行文本
        多行文本
        """

        // 模板
        var h = 20
        var i = "我有 $h 元" // => 我有 20 元

        val j = "abc"
        val k = "$j.length is ${j.length}" // evaluates to "abc.length is 3"

        // String 可以像数据那样被访问，而且可以迭代
        val l = "Example"
        val m = l[2] // 这是一个字符'a'
        // 迭代String
        for (c in l) {
            print(c)
        }
    }
}
