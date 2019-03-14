let select = document.querySelector('#recipient-country');
select.addEventListener('change', () => {
  let selectedValue = select.options[select.selectedIndex].value;

  fetch(`/api/rate?currency=${selectedValue}`, {
    method: 'GET',
  }).then(res => {
    res.text().then(text => {
      let currencyFromApi = text;
      let currency = document.querySelector('#currency');
      currency.querySelector('span').innerHTML = `${currencyFromApi} ${selectedValue}/USD`
    })
  })
});

let submitBtn = document.querySelector('#submit-btn');
submitBtn.addEventListener('click', () => {
  let recipientCountry = select.options[select.selectedIndex].value;
  let wiringAmounts = parseFloat(document.querySelector('#wiring-amounts').value);

  fetch(`/api/rate?currency=${recipientCountry}`, {
    method: 'GET',
  }).then(res => {
    res.text().then(exchangeRate => {
      exchangeRate = exchangeRate.replace(/,/g,'');
      fetch(`/api/submit?recipientCountry=${recipientCountry}
              &exchangeRate=${exchangeRate}&wiringAmounts=${wiringAmounts}`, {
        method: 'GET',
      }).then(res => {
        if (res.ok) {
          res.text().then(reception => {
            let result = document.querySelector('#result');
            result.innerHTML = `수취금액은 ${reception} ${recipientCountry} 입니다.`
          })
        } else if (res.status === 400) {
          alert('송금액이 바르지 않습니다')
        } else if (res.status === 500) {
          alert('서버 점검 중입니다')
        }
      }).catch(err => {
        console.log(err)
      })
    })
  })
});