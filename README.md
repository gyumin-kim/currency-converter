# currency-converter

## Overview
선택한 국가의 실시간 달러 환율을 바탕으로 화폐 계산을 수행합니다.

## Setup
- ZIP 파일을 다운로드 받습니다.
- 혹은, repository를 clone해도 됩니다.
```
> git clone https://github.com/gyumin-kim/currency-converter.git
```
- `src/main/resources`에 `application.properties` 파일을 생성하고, 다음의 설정값들을 적어줍니다.
  - access-key
  - api-url
  - currencies
  
## Getting Started
1. **수취국가**를 선택합니다.  
  *한국(KRW), 일본(JPY), 필리핀(PHP)* 중 선택
2. **송금액**을 입력합니다.
3. **Submit** 버튼을 누르면, 해당 국가의 달러 환율이 나타납니다.
