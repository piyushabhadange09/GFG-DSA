//{ Driver Code Starts
// Initial Template for javascript

// Position this line where user code will be pasted.

function validate(original, order) {
    let mp = new Map();

    for (const word of original) {
        for (const ch of word) {
            mp.set(ch, 1);
        }
    }

    for (const ch of order) {
        if (!mp.has(ch)) return false;
        mp.delete(ch);
    }

    if (mp.size !== 0) return false;

    let indexMap = new Map();
    for (let i = 0; i < order.length; i++) {
        indexMap.set(order[i], i);
    }

    for (let i = 0; i < original.length - 1; i++) {
        const a = original[i], b = original[i + 1];
        let k = 0, n = a.length, m = b.length;

        while (k < n && k < m && a[k] === b[k]) k++;

        if (k < n && k < m && indexMap.get(a[k]) > indexMap.get(b[k])) {
            return false;
        }

        if (k !== n && k === m) {
            return false;
        }
    }
    return true;
}

const readline = require('readline');

const rl = readline.createInterface({input : process.stdin, output : process.stdout});

let testCases = null;
let wordsArray = [];
let currentTestCase = 0;

rl.on('line', (line) => {
    if (testCases === null) {
        testCases = parseInt(line.trim());
    } else {
        wordsArray.push(line.trim().split(" "));

        if (++currentTestCase === testCases) {
            rl.close();
        }
    }
});

rl.on('close', () => {
    for (let i = 0; i < wordsArray.length; i++) {
        const words = wordsArray[i];
        const original = [...words ];

        const solution = new Solution();
        const order = solution.findOrder(words);

        if (order === "") {
            console.log("\"\"");
        } else {
            console.log(validate(original, order) ? "true" : "false");
        }
        console.log("~");
    }
});

// } Driver Code Ends


// User function Template for javascript
class Solution {
    findOrder(words) {
        // code here
           const n = words.length;
        const adj = Array.from({ length: 26 }, () => []);   // Adjacency list for 26 letters
        const present = Array(26).fill(false);              // Track present characters
        const indegree = Array(26).fill(0);                 // In-degree array

        // Mark present characters
        for (const word of words) {
            for (const c of word) {
                present[c.charCodeAt(0) - 'a'.charCodeAt(0)] = true;
            }
        }

        // Build graph from adjacent words
        for (let i = 0; i < n - 1; i++) {
            const str1 = words[i];
            const str2 = words[i + 1];
            const len = Math.min(str1.length, str2.length);
            let check = false;

            for (let ind = 0; ind < len; ind++) {
                if (str1[ind] !== str2[ind]) {
                    const u = str1.charCodeAt(ind) - 'a'.charCodeAt(0);
                    const v = str2.charCodeAt(ind) - 'a'.charCodeAt(0);
                    adj[u].push(v);
                    indegree[v]++;
                    check = true;
                    break;
                }
            }

            // Invalid case: str1 is longer and is a prefix of str2
            if (!check && str1.length > str2.length) {
                return "";
            }
        }

        // Topological sort using Kahn's algorithm
        const q = [];
        for (let i = 0; i < 26; i++) {
            if (present[i] && indegree[i] === 0) {
                q.push(i);
            }
        }

        let ans = "";
        while (q.length > 0) {
            const node = q.shift();
            ans += String.fromCharCode(node + 'a'.charCodeAt(0));

            for (const neighbor of adj[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] === 0) {
                    q.push(neighbor);
                }
            }
        }

        // Check for cycle
        for (let i = 0; i < 26; i++) {
            if (present[i] && indegree[i] > 0) {
                return "";  // Cycle detected
            }
        }

        return ans;

    }
}