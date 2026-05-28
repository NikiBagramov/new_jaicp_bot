require: slotfilling/slotFilling.sc
  module = sys.zb-common

patterns:
    $hello = * (привет*|здравств*|добрый (день|вечер|утро)|хай|hello) *
    $weather = * (погод*|прогноз*|температур*|градус*|дожд*) *
    $currency = * (курс*|валют*|доллар*|евро*|обмен*) *

theme: /

    state: Start
        q!: $regex</start>
        a: Здравствуйте! Я могу подсказать погоду и курс валют.

    state: hello
        q!: $hello
        intent!: /hello
        a: Здравствуйте! Я бот-помощник. Спросите меня о погоде или курсе валют.

    state: weather
        q!: $weather
        intent!: /weather
        a: Сейчас подскажу погоду: сегодня ожидается переменная облачность, без сильных осадков.

    state: currency
        q!: $currency
        intent!: /currency
        a: Сейчас подскажу курс валют: курс доллара и евро меняется ежедневно, уточните нужную валюту в банке или обменнике.

    state: NoMatch
        event!: noMatch
        a: Я не понял запрос. Я могу ответить на приветствие, рассказать о погоде или курсе валют.
