const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let A, B;

rl.on("line", (line) => {
  [A, B] = line.split(" ").map(Number); // 문자열을 숫자로 변환
  rl.close(); // 입력 한 줄 받았으면 종료
}).on("close", () => {
  console.log(A + B);
});
