1. 1. Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?
   Если может - приведите пример, когда.

$("h1 div") все div которые находятся в h1.
$("h1").$("div") ищет вначале h1, и затем ищет в нем div. Если div не будет - ошибка.

