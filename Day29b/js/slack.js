var token = "xoxp-[REDACTED]";

$.ajax("https://slack.com/api/auth.test?token=xoxp-63743851541-79242144225-82798956418-452e55b58f6e92ebe4481ce997296fed&pretty=1", {
  method: "POST"
}).then(function(result) {
  console.log(result);
});
