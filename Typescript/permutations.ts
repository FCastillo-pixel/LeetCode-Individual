function permutate(nums: number[]): number[][] {
    const result: number[][] = [];

    function backtrack(path: number[], options: number[]): void {
        if (options.length === 0) {
            result.push([...path]);
            return;
        }

        for (let i = 0; i < options.length; i++) {
            const newPath = [...path, options[i]];
            const newOptions = [...options.slice(0,i), ...options.slice(i+1)];
            backtrack(newPath, newOptions);
        }
    }

    backtrack([], nums);
    return result;
};