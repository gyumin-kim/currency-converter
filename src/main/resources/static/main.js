let select = document.querySelector('#recipient-country');
select.addEventListener('change', () => {
  let selectedValue = select.options[select.selectedIndex].value;

  fetch(`/api/currencies?currency=${selectedValue}`, {
    method: 'GET',
  }).then((res) => {
    res.text().then(text => {
      let currencyFromApi = text;
      let currency = document.querySelector('#currency');
      currency.querySelector('span').innerHTML = `${currencyFromApi} ${selectedValue}/USD`;
    })
  });
});

let submitBtn = document.querySelector('#submit-btn');
submitBtn.addEventListener('click', () => {
  let recipientCountry = select.options[select.selectedIndex].value;
  let wiringAmounts = parseFloat(document.querySelector('#wiring-amounts').value);

  fetch(`/api/currencies?currency=${recipientCountry}`, {
    method: 'GET',
  }).then(res => {
    res.text().then(exchangeRate => {
      exchangeRate = exchangeRate.replace(/,/g,'');
      fetch(`/api/submit?recipientCountry=${recipientCountry}
              &exchangeRate=${exchangeRate}&wiringAmounts=${wiringAmounts}`, {
        method: 'GET',
      }).then((res) => {
        res.text().then(reception => {
          let result = document.querySelector('#result');
          result.innerHTML = `수취금액은 ${reception} 입니다.`;
        })
      });
    })
  });
});