
# react-native-keyboard-library

## Getting started

`$ npm install react-native-keyboard-library --save`

### Mostly automatic installation

`$ react-native link react-native-keyboard-library`

### Manual installation

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNKeyboardLibraryPackage;` to the imports at the top of the file
  - Add `new RNKeyboardLibraryPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-keyboard-library'
  	project(':react-native-keyboard-library').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-keyboard-library/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      implementation project(':react-native-keyboard-library')
  	```
## Usage
```javascript
import React, { Component } from 'react';
import { Platform, StyleSheet, Text, View } from 'react-native';
import Keyboard from 'react-native-keyboard-library';

const instructions = Platform.select({
    ios: 'Press Cmd+R to reload,\n' + 'Cmd+D or shake for dev menu',
    android: 'Double tap R on your keyboard to reload,\n' +
        'Shake or press menu button for dev menu',
});

export default class App extends Component {
    componentDidMount(){
        Keyboard.open()
        setTimeout(()=>Keyboard.closed(),2000);
    }
    onClick() {
        Keyboard.toggle();
    }
    render() {
        console.log('RNKeyboardLibrary', Keyboard);
        return ( 
            <View style={ styles.container }>
                <Text onPress={this.onClick} style={ styles.welcome }>Welcome to React Native!</Text>
                <Text style={ styles.instructions }>To get started, edit App.js</Text>
                <Text style={ styles.instructions }>{ instructions }</Text>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
    },
    welcome: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
    instructions: {
        textAlign: 'center',
        color: '#333333',
        marginBottom: 5,
    },
});
```
  