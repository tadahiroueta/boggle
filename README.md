# Boggle
***A Java-based game of Boggle with an AI opponent and calculated perfect solutions***

[Built With](#built-with) · [Features](#features) · [Installation](#installation) · [Usage](#usage)

## Built With

- ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=oracle&logoColor=white)

## Features

### Faithful to original Boggle
Same rules and point system

![full-game](https://github.com/tadahiroueta/ant-colony/blob/master/samples/full-game.gif)

### Perfect solution calculated
```BoggleSolver.java``` iterates through all non-repeating possible combinations to find valid words. Results are shown on ```Possible Points``` table.

![perfect-solution](https://github.com/tadahiroueta/ant-colony/blob/master/samples/perfect-solution.gif)

### Multiple dictionaries  
Different dictionaries allow for different difficulties

![settings](https://github.com/tadahiroueta/ant-colony/blob/master//samples/settings.png)

```
200345	SAPONIFY
200346	SAPONIFYING
200347	SAPONIN
200348	SAPONINE
200349	SAPONINES
200350	SAPONINS
200351	SAPONITE
200352	SAPONITES
200353	SAPOR
200354	SAPORIFIC
200355	SAPOROUS
200356	SAPORS
200357	SAPOTA
200358	SAPOTACEOUS
200359	SAPOTAS
200360	SAPOTE
200361	SAPOTES
200362	SAPOUR
200363	SAPOURS
200364	SAPPAN
200365	SAPPANS
200366	SAPPANWOOD
200367	SAPPANWOODS
200368	SAPPED
200369	SAPPER
200370	SAPPERMENT
200371	SAPPERMENTS
```

## Installation

1. Install a JDK
    > I recommend [Red Hat's](https://developers.redhat.com/products/openjdk/download?source=sso)

2. Clone repository
    ```sh
    git clone https://github.com/tadahiroueta/game-of-life.git
    ```

## Usage

1. Run ```BoggleGame.java```

