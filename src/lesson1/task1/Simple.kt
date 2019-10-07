@file:Suppress("UNUSED_PARAMETER")
package lesson1.task1

import java.lang.Math.pow
import kotlin.math.*

/**
 * Пример
 *
 * Вычисление квадрата целого числа
 */
fun sqr(x: Int) = x * x

/**
 * Пример
 *
 * Вычисление квадрата вещественного числа
 */
fun sqr(x: Double) = x * x

/**
 * Пример
 *
 * Вычисление дискриминанта квадратного уравнения
 */
fun discriminant(a: Double, b: Double, c: Double) = sqr(b) - 4 * a * c

/**
 * Пример
 *
 * Поиск одного из корней квадратного уравнения
 */
fun quadraticEquationRoot(a: Double, b: Double, c: Double) =
        (-b + sqrt(discriminant(a, b, c))) / (2 * a)

/**
 * Пример
 *
 * Поиск произведения корней квадратного уравнения
 */
fun quadraticRootProduct(a: Double, b: Double, c: Double): Double {
    val sd = sqrt(discriminant(a, b, c))
    val x1 = (-b + sd) / (2 * a)
    val x2 = (-b - sd) / (2 * a)
    return x1 * x2 // Результат
}

/**
 * Пример главной функции
 */
fun main(args: Array<String>) {
    val x1x2 = quadraticRootProduct(1.0, 13.0, 42.0)
    println("Root product: $x1x2")
}

/**
 * Тривиальная
 *
 * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
 * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
 */
fun seconds(hours: Int, minutes: Int, seconds: Int): Int {
    val secondsInMinute = 60
    val secondsInHour = 60 * secondsInMinute
    val hourSeconds = hours * secondsInHour
    val minutesSeconds = minutes * secondsInMinute
    return hourSeconds + minutesSeconds + seconds
}

/**
 * Тривиальная
 *
 * Пользователь задает длину отрезка в саженях, аршинах и вершках (например, 8 саженей 2 аршина 11 вершков).
 * Определить длину того же отрезка в метрах (в данном случае 18.98).
 * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.
 */
fun lengthInMeters(sagenes: Int, arshins: Int, vershoks: Int): Double {
    val sagenesToVershoks = 48
    val arshinsToVershoks = 48.0 / 3
    val vershoksToCentimeter = 4.445
    val centimeterToMeter = 1.0 / 100
    val sagenesToMeter = sagenes * sagenesToVershoks * vershoksToCentimeter * centimeterToMeter
    val arshinsToMeter = arshins * arshinsToVershoks * vershoksToCentimeter * centimeterToMeter
    val vershoksToMetr = vershoks * vershoksToCentimeter * centimeterToMeter
    return sagenesToMeter + arshinsToMeter + vershoksToMetr
}

/**
 * Тривиальная
 *
 * Пользователь задает угол в градусах, минутах и секундах (например, 36 градусов 14 минут 35 секунд).
 * Вывести значение того же угла в радианах (например, 0.63256).
 */
fun angleInRadian(deg: Int, min: Int, sec: Int): Double {
    val radian = PI / 180
    val degreesToRadian = deg * radian
    val minutesToRadian = min * radian / 60
    val secondsToRadian = sec * radian / (60 * 60)
    return degreesToRadian + minutesToRadian + secondsToRadian
}

/**
 * Тривиальная
 *
 * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
 * Например, расстояние между (3, 0) и (0, 4) равно 5
 */
fun trackLength(x1: Double, y1: Double, x2: Double, y2: Double): Double {
    val distanceX = pow(x2 - x1, 2.0)
    val distanceY = pow(y2 - y1, 2.0)
    return sqrt(distanceX + distanceY)
}

/**
 * Простая
 *
 * Пользователь задает целое число, большее 100 (например, 3801).
 * Определить третью цифру справа в этом числе (в данном случае 8).
 */
fun thirdDigit(number: Int): Int {
    val tenths = number / 10
    val hundredths = tenths / 10
    return hundredths % 10
}

/**
 * Простая
 *
 * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
 * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
 * Определите время поезда в пути в минутах (в данном случае 216).
 */
fun travelMinutes(hoursDepart: Int, minutesDepart: Int, hoursArrive: Int, minutesArrive: Int): Int {
    val hoursToMinutes = 60
    val startTime = hoursDepart * hoursToMinutes + minutesDepart
    val endTime = hoursArrive * hoursToMinutes + minutesArrive
    return endTime - startTime
}

/**
 * Простая
 *
 * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
 * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
 * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
 */
fun accountInThreeYears(initial: Int, percent: Int): Double {
    fun moneyForYear(initial: Double, percent: Int): Double =
            initial * (percent / 100.0)

    var money = initial.toDouble()
    for (i in 1..3) {
        money += moneyForYear(money, percent)
    }
    return money
}

/**
 * Простая
 *
 * Пользователь задает целое трехзначное число (например, 478).
 * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
 */
fun numberRevert(number: Int): Int {
    var num = number
    var tmp = 100
    var tenths = number % 10 * tmp
    for (i in 1..2) {
        num /= 10
        tmp /= 10
        tenths += (num % 10) * tmp
    }
    return tenths
}
